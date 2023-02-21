package cn.itcast.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@WebFilter("/*")
public class SensitiveWordsFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        ServletRequest proxy_req = (ServletRequest) Proxy.newProxyInstance(req.getClass().getClassLoader(), req.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //判断是否是getParameter方法
                if (method.getName().equals("getParameter")) {
                    String value = (String) method.invoke(req, args);
                    if (value != null) {
                        for (String s : list) {
                            if (value.contains(s)) {
                                value = value.replaceAll(s, "***");
                            }
                        }
                    }
                    return value;
                }
                //判断方法名是否是 getParameterMap
                if (method.getName().equals("getParameterMap")) {
                    Map<String, String[]> map = (Map<String, String[]>) method.invoke(req, args);
                    Set<String> keySet = map.keySet();
                    for (String key : keySet) {
                        for (String s : list) {
                            if (map.get(key)[0].contains(s)) {
                                map.get(key)[0] = map.get(key)[0].replaceAll(s, "***");
                            }
                        }
                    }
                    return map;
                }
                //判断方法名是否是 getParameterValue
                if (method.getName().equals("getParameterValue")) {
                    List<String> list = (List<String>) method.invoke(req, args);
                    for (String value : list) {
                        if (value != null) {
                            for (String s : list) {
                                if (value.contains(s)) {
                                    value = value.replaceAll(s, "***");
                                }
                            }
                        }
                    }
                    return list;
                }

                return method.invoke(req, args);
            }
        });
        chain.doFilter(proxy_req, resp);
    }

    private List<String> list = new ArrayList<>();

    public void init(FilterConfig config) throws ServletException {
        try {
            ServletContext servletContext = config.getServletContext();
            String realPath = servletContext.getRealPath("/WEB-INF/classes/敏感词汇.txt");
            BufferedReader br = new BufferedReader(new FileReader(realPath));
            String line = null;
            while ((line = br.readLine()) != null) {
                list.add(line);
            }
            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

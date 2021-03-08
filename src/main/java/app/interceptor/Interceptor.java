//package app.interceptor;
//
//import app.storage.TokenStorage;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.web.servlet.HandlerInterceptor;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//@Component
//public class Interceptor implements HandlerInterceptor {
//
//    @Autowired
//    private TokenStorage tokenStorage;
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        String header = request.getHeader("X-Token");
//        if(tokenStorage.valid(header)) {
//            return true;
//        } else {
//            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
//            return false;
//        }
//    }
//}

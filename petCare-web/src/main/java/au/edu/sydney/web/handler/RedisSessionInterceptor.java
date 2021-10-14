package au.edu.sydney.web.handler;

import au.edu.sydney.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Chris
 * @date 2021-10-13 16:14
 * @description
 */
@Slf4j
@Component
public class RedisSessionInterceptor implements HandlerInterceptor {

    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        boolean isLogin = false;
//
//        // Authorization: Bearer jwtToken
//        final String authHeader = request.getHeader("Authorization");
//
//        if (StringUtils.isNotBlank(authHeader) && authHeader.startsWith("Bearer ")) {
//
//            final String token = authHeader.substring(7);
//            Claims claims = jwtUtil.parseJWT(token);
//            String userId = claims.getId();
//            String redisToken = (String) redisTemplate.opsForValue().get("TOKEN_" + userId);
//            log.info(redisToken);
//            if (token.equals(redisToken)) {
//                isLogin = true;
//            }
//        }
//
//        if (!isLogin) {
////            response.setContentType("application/json;charset=UTF-8");
////            response.setCharacterEncoding("UTF-8");
////            response.setStatus(401);
////            response.getWriter().write("未通过认证，请先进行登录");
//            response.sendRedirect(request.getContextPath() + "/homelogin");
//        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}

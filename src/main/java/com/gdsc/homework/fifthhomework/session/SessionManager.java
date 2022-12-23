package com.gdsc.homework.fifthhomework.session;

import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class SessionManager {

    // 상수로 만드는 단축키 => 컨트롤 + 알트 + C
    public static final String SESSION_COOKIE_NAME = "mySessionId";
    private Map<String,Object> sessionStore = new ConcurrentHashMap<>();

    /**
     * 세션 생성
     * * sessionId 생성(임의의 추청 불가능한 랜덤 값)
     * * 세션 저장소에 sessionId와 보관함 값 저장
     * * sessionId로 응답 쿠키를 생성해서 클라이언트에 전달
     */

    public void createSession(Object value, HttpServletResponse response){
        // 세션 아이디를 생성하고, 값을 세션에 저장
        String sessionId = UUID.randomUUID().toString();
        sessionStore.put(sessionId,value);

        // 쿠키 생성
        Cookie mySessionCookie = new Cookie(SESSION_COOKIE_NAME, sessionId);
        response.addCookie(mySessionCookie);
    }

    /**
     * 세션 조회
     */
    public Object getSession(HttpServletRequest request){
//        Cookie[] cookies = request.getCookies();
//        if(cookies==null){
//            return null;
//        }
//        for (Cookie cookie : cookies) {
//            if(cookie.getName().equals(SESSION_COOKIE_NAME)){
//                return sessionStore.get(SESSION_COOKIE_NAME);
//            }
//        }
//        return null;
        Cookie sessionCookie = findCookie(request, SESSION_COOKIE_NAME);
        if(sessionCookie==null){
            return null;
        }
        return sessionStore.get(sessionCookie.getValue());
    }

    public Cookie findCookie(HttpServletRequest request,String cookieName){
        Cookie[] cookies = request.getCookies();
        if(cookies==null){
            return null;
        }

        // 배열을 스트림으로 바꿔준다. 스트림 문법도 알아두기
        return Arrays.stream(cookies)
                .filter(m->m.getName().equals(cookieName))
                .findAny().orElse(null);
    }


    /**
     * 세션 만료
     */
    public void expire(HttpServletRequest request){
        Cookie sessionCookie = findCookie(request,SESSION_COOKIE_NAME);
        if(sessionCookie!=null){
            // 키값으로 세션스토어에 있는 키,벨류를 지운다.
            sessionStore.remove(sessionCookie.getValue());
        }
    }
}

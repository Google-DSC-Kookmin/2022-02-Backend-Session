package com.gdsc.homework.auth;

import com.gdsc.homework.jwt.JwtHeader;
import com.gdsc.homework.jwt.JwtService;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;

@Component
public class UserIdResolver implements HandlerMethodArgumentResolver {

    private final JwtService jwtService;

    public UserIdResolver(final JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @Override
    public boolean supportsParameter(final MethodParameter parameter) {
        return parameter.hasParameterAnnotation(UserId.class) && Long.class.equals(parameter.getParameterType());
    }

    @Override
    public Object resolveArgument(@NotNull final MethodParameter parameter, final ModelAndViewContainer mavContainer, @NotNull final NativeWebRequest webRequest, final WebDataBinderFactory binderFactory) {
        final HttpServletRequest request = (HttpServletRequest) webRequest.getNativeRequest();
        final String token = request.getHeader(JwtHeader.AUTH);
        if (!jwtService.verifyToken(token)) {
            return null;
        }

        final String subject = jwtService.getSubject(token);

        try {
            return Long.parseLong(subject);
        } catch (final NumberFormatException e) {
            return null;
        }
    }
}
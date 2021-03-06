package com.aruerue.shop.config.jwt;

import java.io.IOException;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.aruerue.shop.config.auth.PrincipalDetails;
import com.aruerue.shop.controller.dto.LoginRequestDto;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter{

	private final AuthenticationManager authenticationManager;

	// Authentication 객체 만들어서 리턴 => 의존 : AuthenticationManager
	// 인증 요청시에 실행되는 함수 => /login
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {

		System.out.println("jwt.JwtAuthenticationFilter.java의  attemptAuthentication에 왔습니다.");

		// request에 있는 username과 password를 파싱해서 자바 Object로 받기
		ObjectMapper om = new ObjectMapper();
		LoginRequestDto loginRequestDto = null;
		try {
			loginRequestDto = om.readValue(request.getInputStream(), LoginRequestDto.class);
			System.out.println("jwt.JwtAuthenticationFilter.java의  loginRequestDto= "+loginRequestDto);
		} catch (Exception e) {
			e.printStackTrace();
		}



		// 유저네임패스워드 토큰 생성
		UsernamePasswordAuthenticationToken authenticationToken =
				new UsernamePasswordAuthenticationToken(
						loginRequestDto.getUsername(),
						loginRequestDto.getPassword());

		System.out.println("JwtAuthenticationFilter : 토큰생성완료");
		System.out.println("JwtAuthenticationFilter : 토큰 = "+authenticationToken.getPrincipal());


		// authenticate() 함수가 호출 되면 인증 프로바이더가 유저 디테일 서비스의
		// loadUserByUsername(토큰의 첫번째 파라메터) 를 호출하고
		// UserDetails를 리턴받아서 토큰의 두번째 파라메터(credential)과
		// UserDetails(DB값)의 getPassword()함수로 비교해서 동일하면
		// Authentication 객체를 만들어서 필터체인으로 리턴해준다.

		// Tip: 인증 프로바이더의 디폴트 서비스는 UserDetailsService 타입
		// Tip: 인증 프로바이더의 디폴트 암호화 방식은 BCryptPasswordEncoder
		// 결론은 인증 프로바이더에게 알려줄 필요가 없음.
		Authentication authentication =
				authenticationManager.authenticate(authenticationToken);
		System.out.println("jwt.JwtAuthenticationFilter.java의  attemptAuthentication의 authentication ="+authentication);
		PrincipalDetails principalDetailis = (PrincipalDetails) authentication.getPrincipal();
		System.out.println("jwt.JwtAuthenticationFilter.java의  attemptAuthentication의 principalDetailis ="+principalDetailis);
		System.out.println("jwt.JwtAuthenticationFilter.java의  attemptAuthentication의 principalDetailis = "+principalDetailis.getUser().getUsername());
		return authentication;
	}

	// JWT Token 생성해서 response에 담아주기
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		System.out.println("jwt.JwtAuthenticationFilter.java의  attemptAuthentication의 successfulAuthentication에 왓습니다");

		PrincipalDetails principalDetailis = (PrincipalDetails) authResult.getPrincipal();
		System.out.println("jwt.JwtAuthenticationFilter.java의  attemptAuthentication의 principalDetailis= "+principalDetailis.getUsername());

		String jwtToken = JWT.create()
				.withSubject(principalDetailis.getUsername())
				.withExpiresAt(new Date(System.currentTimeMillis()+JwtProperties.EXPIRATION_TIME))
				.withClaim("id", principalDetailis.getUser().getId())
				.withClaim("username", principalDetailis.getUser().getUsername())
				.sign(Algorithm.HMAC512(JwtProperties.SECRET));
		System.out.println("jwt.JwtAuthenticationFilter.java의  attemptAuthentication의 jwtToken= "+jwtToken);

		response.addHeader(JwtProperties.HEADER_STRING, JwtProperties.TOKEN_PREFIX+jwtToken);
		//chain.doFilter(request, response);
	}
}

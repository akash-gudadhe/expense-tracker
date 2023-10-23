// package com.expensetracker.simpleexpense.service;

// import java.security.Key;
// import java.util.Date;
// import java.util.HashMap;

// import io.jsonwebtoken.Jwts;
// import io.jsonwebtoken.SignatureAlgorithm;
// import io.jsonwebtoken.io.Decoders;
// import io.jsonwebtoken.security.Keys;

// public class JwtService {
    
//     public static final String SECRET = "Gp1/8r9QfuzQ/uWoNDv2Q7aQ9K3oo3KxFdRg7vzIiIs=";

//     public Object generateToken(String userName){
//         HashMap<String, Object> claims = new HashMap();


//         return createToken(claims, userName);
//     }

//     private Object createToken(HashMap<String, Object> claims, String userName) {
//         return Jwts.builder()
//                     .setClaims(claims)
//                     .setSubject(userName)
//                     .setIssuedAt(new Date(System.currentTimeMillis()))
//                     .setExpiration(new Date(System.currentTimeMillis()+1000*60*5))
//                     .signWith(getSignKey(), SignatureAlgorithm.HS256);

//     }

//     private Key getSignKey() {
//         byte[] keyBytes = Decoders.BASE64.decode(SECRET);

//         return Keys.hmacShaKeyFor(keyBytes);
//     }
// }

import { HttpInterceptorFn } from '@angular/common/http';

export const jwtHeaderInterceptor: HttpInterceptorFn = (req, next) => {
  console.log("INTERCEPTION !!");

  const authRequest = req.clone({
    setHeaders: {
      'Authorization': "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyIiwiaWF0IjoxNzQ1NDk4MjQ0LCJleHAiOjE3NDU1MDE4NDR9.Z59OkTHV204DT4W3LE_IV76a0wYut_lDsL7aQsAlH-6x_qnM_lGZWgO8jJOoifiOJjqkmTVMTsGEnnMMftZfIA"
    }
  });

  return next(authRequest);
};

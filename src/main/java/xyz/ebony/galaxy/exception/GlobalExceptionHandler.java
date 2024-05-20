package xyz.ebony.galaxy.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import xyz.ebony.galaxy.dto.ResultDto;
import xyz.ebony.galaxy.enums.ReturnCodeEnum;

@RestControllerAdvice
public class GlobalExceptionHandler {
  @ExceptionHandler(BusinessException.class)
  public <T> ResultDto<T> doBusException(BusinessException e) {
    return ResultDto.error(e.getCode(), e.getMessage());
  }

  @ExceptionHandler
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public <T> ResultDto<T> doException(Exception e) {
    return ResultDto.error(ReturnCodeEnum.RC500.getCode(), e.getMessage());
  }
}


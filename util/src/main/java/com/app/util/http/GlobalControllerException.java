package com.app.util.http;

import com.app.api.exception.BadRequestException;
import com.app.api.exception.NotFoundException;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.http.server.reactive.ServerHttpRequest;

@ControllerAdvice
public class GlobalControllerException {

    private static final Logger LOG = LoggerFactory.getLogger(GlobalControllerException.class);

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BadRequestException.class)
    public @ResponseBody HttpInfo badRequestException(ServerHttpRequest serverHttpRequest,
                                                    BadRequestException ex){
        return createHttpInfo(HttpStatus.BAD_REQUEST, serverHttpRequest, ex);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public @ResponseBody HttpInfo notFoundException(ServerHttpRequest serverHttpRequest,
                                                    NotFoundException ex){

        return createHttpInfo(HttpStatus.NOT_FOUND, serverHttpRequest, ex);
    }



    public HttpInfo createHttpInfo(HttpStatus httpStatus,
                                   ServerHttpRequest serverHttpRequest,
                                   Exception ex){
        final String path = serverHttpRequest.getPath().pathWithinApplication().value();
        final String message = ex.getMessage();

        LOG.info("Response global for path: {} with message:  {} and status: {}",
                path,
                httpStatus.value(),
                message);

        return new HttpInfo(message, path, httpStatus);
    }
}

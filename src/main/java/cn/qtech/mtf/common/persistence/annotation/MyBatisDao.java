package cn.qtech.mtf.common.persistence.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * Created by mtf on 2016/9/8.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Component
public @interface MyBatisDao {
}

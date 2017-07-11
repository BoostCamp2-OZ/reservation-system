package connect.reservation.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;



@Configuration
//dao, service에 대한 컴포넌트를 scan한다. sevice는 미리 추가한다.
@ComponentScan(basePackages = {
   "connect.reservation.dao",
   "connect.reservation.service"
})
@Import({DBConfig.class}) // DBConfig 를 설정한다.
public class RootApplicationContextConfig {

}

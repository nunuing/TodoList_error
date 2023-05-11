package WebProject.TodoList;

import WebProject.TodoList.repository.JdbcListCompRepository;
import WebProject.TodoList.repository.ListRepository;
import WebProject.TodoList.repository.MemoryListCompRepository;
import WebProject.TodoList.service.ListCompService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {
    private final DataSource dataSource;

    public SpringConfig(DataSource dataSource){
        this.dataSource = dataSource;
    }
    @Bean
    public ListCompService listCompService(){
        return new ListCompService(listRepository());
    }

    @Bean
    public ListRepository listRepository(){
        //return new MemoryListCompRepository();
        return new JdbcListCompRepository(dataSource);
    }
}

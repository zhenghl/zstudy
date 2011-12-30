package servlet;

import java.io.IOException;
import java.util.List;
import java.util.Random;


import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import liaoo.springhibernatear.dao.IUserDAO;
import liaoo.springhibernatear.entity.User;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.context.ApplicationContext;
import org.springframework.web.util.UrlPathHelper;
import org.springframework.web.context.support.WebApplicationContextUtils; 

import com.hoo.bean.NewsService;
import com.hoo.controller.HelloWorldController;

import com.mongo.Person;
import com.mongo.PersonRepository;
import com.mybatis.*;

/**
 * Servlet implementation class LogInitServlet
 */
public class LogInitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger = null;
       
	private ServletConfig conf=null;   
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogInitServlet() {
        super();
    }
    
    public void init(ServletConfig config) throws ServletException {
    	
    	super.init(config); 

		this.conf=config;   
		ServletContext application=this.conf.getServletContext();   
		//设置Application属性   
		application.setAttribute("count", "0");   
		
        String log4jConfig = config.getInitParameter("log4jConfig");
        String log4jConfigFullPath = application.getRealPath("/") +  log4jConfig;
        PropertyConfigurator.configure(log4jConfigFullPath);
        
        logger = Logger.getLogger(LogInitServlet.class);
        logger.info("init log4jConfig         : " + log4jConfig);
        logger.info("init log4jConfig FullPath: " + log4jConfigFullPath);
		logger.info("init String contextConfigLocation: " + config.getServletContext().getInitParameter("contextConfigLocation"));
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int i = 1;
		i = i +1;
		
		ServletContext application = this.getServletConfig().getServletContext();

		
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext application=this.conf.getServletContext(); 
		
		int count = Integer.parseInt(application.getAttribute("count").toString()) + 1;
		
		
		//设置Application属性   
		application.setAttribute("count", count);
		
		response.getOutputStream().println("request count:" + count);
		
		/*
		// 根目录所对应的绝对路径:
		logger.info( request.getRequestURI() );
		
		// 文件的绝对路径
		logger.info( application.getRealPath(request.getRequestURI() ) );

		// 当前web应用的绝对路径
		logger.info( application.getRealPath("/") );

		// Servlet中获得当前应用的相对路径和绝对路径
		// 根目录所对应的绝对路径:
		logger.info( request.getServletPath() );
		
		// 文件的绝对路径
		logger.info( request.getSession().getServletContext().getRealPath(request.getRequestURI()) );
		 
		// 当前web应用的绝对路径 
		logger.info( application.getRealPath("/") );
		*/
		
		ApplicationContext springAppContext = WebApplicationContextUtils.getWebApplicationContext(application);
		HelloWorldController hiBean = (HelloWorldController)springAppContext.getBean("hiBean");
		hiBean.testBean();
		logger.info( "hiBean Hash Code : " + hiBean.toString() );
		
//		NewsService newsSrv = (NewsService)springAppContext.getBean("newsSrv");
//		logger.info( "newsSrvBean getNews   : " + newsSrv.getNews() );
//		logger.info( "newsSrvBean Hash Code : " + newsSrv.toString() );
//		
//		UserService userService = (UserService)springAppContext.getBean("userService");
//        logger.info( "userService countAll : " + userService.countAll() );
//        
//        StudentMapper studentMapper = (StudentMapper)springAppContext.getBean("studentMapper");
//        logger.info( "studentMapper.getStudent : " + studentMapper.getStudent("123456") );
//        
//        StudentEntity entity = new StudentEntity();
//        entity.setStudentID("123457");
//        entity.setStudentName("郑");
//        //studentMapper.insertStudent(entity);
//        
//        List<StudentEntity> studentList = studentMapper.getStudentAll();  
//        for( StudentEntity entityTemp : studentList){  
//        	logger.info(entityTemp.getStudentName());  
//        }
        
//		logger.info( "hibernate test start:");
//        IUserDAO userDAO =  (IUserDAO) springAppContext.getBean("userDAO");
//        User user = new User();
//        Random rand = new Random();
//        user.setId(rand.nextInt(10000));
//        user.setName("jackyrong " + rand.nextInt(10000));
//        userDAO.insert(user);
//        logger.info( "hibernate test end");
        
        testMongoDB(springAppContext);
	}
	
	private void testMongoDB(ApplicationContext springAppContext) {
		logger.info("Bootstrapping MongoDemo application");

        //PersonRepository personRepository = springAppContext.getBean(PersonRepository.class);
        PersonRepository personRepository = (PersonRepository)springAppContext.getBean("personRepository");

        // cleanup person collection before insertion
        //personRepository.dropPersonCollection();

        //create person collection
        //personRepository.createPersonCollection();

        for(int i=0; i<20; i++) {
            personRepository.insertPersonWithNameJohnAndRandomAge();
        }

        personRepository.logAllPersons();
        logger.info("Avarage age of a person is: " + personRepository.getAvarageAgeOfPerson());
        
        List<Person> persions = personRepository.logAllPersons();
        logger.info("Total search person count: " + persions.size());
        if(persions != null && persions.size() >0 ) {
            for(int i=0; i<10; i++) {
            	logger.info("Person " + i + " : " + persions.get(i));
            }
        } else {
        	logger.info("No search person!");
        }

        logger.info("Finished MongoDemo application");
	}
}

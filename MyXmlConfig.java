package book_my_show.helper;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MyXmlConfig extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		Class[] show={showConfig.class};
		return show;
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		String[] show={"/"};
		return show;
	}

}

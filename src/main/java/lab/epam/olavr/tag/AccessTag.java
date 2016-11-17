package lab.epam.olavr.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import lab.epam.olavr.dao.UserDB;

public class AccessTag extends SimpleTagSupport {
	    private boolean anon = false;
	    private boolean admin = false;
	    private boolean user = false;

	    @Override
	    public void doTag() throws JspException, IOException {
	        JspWriter out = getJspContext().getOut();
	        UserDB currentUser = (UserDB) getJspContext().findAttribute("user");
	        if(anon && currentUser==null) {
	            getJspBody().invoke(null);
	        }
	        if(user && currentUser!=null) {
	            getJspBody().invoke(null);
	        }
	        if(admin && currentUser!=null && currentUser.getRoleId()==2) {
	            getJspBody().invoke(null);
	        }
	    }

	    public void setAnon(boolean anon) {
	        this.anon = anon;
	    }

	    public void setAdmin(boolean admin) {
	        this.admin = admin;
	    }

	    public void setUser(boolean user) {
	        this.user = user;
	    }

}

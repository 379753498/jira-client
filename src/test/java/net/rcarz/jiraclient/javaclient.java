package net.rcarz.jiraclient;  

import java.util.List;

import net.rcarz.jiraclient.Issue.FluentCreate;
  
public class javaclient {

	
	public static void main(String[] args) throws JiraException {
		
		JiraClient jira= new JiraClient("http://172.19.0.231:8080/", new BasicCredentials("xujian", "123456"));

		Issue issue = jira.getIssue("HEL-72");
		Object field = issue.getField(Field.COMMENT);
		
	System.out.println(field.toString());
		
//		createbug(jira, "HEL", "任务",field);
		
		
	}
	
	
	
	
	public static Boolean createbug(JiraClient jira,String project,String issueType ,Object field ) throws JiraException
	{
		
		for (int i = 0; i < 5; i++) {
			try {
				 Issue execute = jira.createIssue(project, issueType)
							.field(Field.SUMMARY, "什么玩意")//标题
							.field(Field.DESCRIPTION, "这个是一个死猪")//主体描述
							.field(Field.PRIORITY,"High" )	//等级
							.field(Field.ASSIGNEE  ,"xujian" )	//指派给
							.field(Field.DUE_DATE   ,"2017-08-09" )	//期望完成时间
						    .execute();//执行创建过程
							 System.out.println(execute.getKey());
				
			} catch (Exception e) {
				// TODO: handle exception
				return false;
			}
				

			
		}
		
		
		 
		return true;

	
		
		
	
		
		
		
	}

}

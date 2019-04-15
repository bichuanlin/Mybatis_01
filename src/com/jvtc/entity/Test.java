package com.jvtc.entity;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		addStudent();		
		Reader reader;
		try {
			reader=Resources.getResourceAsReader("conf.xml");
			SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(reader);
			SqlSession sqlSession=factory.openSession();
			String statement="com.jvtc.entity.studentMapper.selectStudentById";
			Student student=sqlSession.selectOne(statement,"20171266");
			System.out.println(student.toString());
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * ���ѧ����Ϣ
	 */
	public static void addStudent(){
		Reader reader;
		try {
			reader=Resources.getResourceAsReader("conf.xml");
			SqlSessionFactory sessionFactory=new SqlSessionFactoryBuilder().build(reader);
			SqlSession session=sessionFactory.openSession();
			String statement="com.jvtc.entity.studentMapper.addStudent";
			//����һ��Ҫ��ӵ�ѧ��
			Student student=new Student();
			student.setId("20171266");
			student.setName("�³�");
			student.setAge(30);
			student.setSex("��");
			int count=session.insert(statement, student);
			session.commit();//����ɾ������Ҫ�ύ����
			System.out.println(count+"��ѧ������ӳɹ���");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

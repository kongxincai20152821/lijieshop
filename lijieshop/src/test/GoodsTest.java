package test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import entity.Goods;
import service.GoodsService;

public class GoodsTest {

	public static void main(String[] args) {
            ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
            GoodsService dao=(GoodsService)ac.getBean("goodsService");
            
            String s="���Ȼ��,ϴ�»�,��ˮ��,���Ĺ�,��ζ����,����,�ǹ�,ţ��,����ȹ,���п�,����װ,java�����ŵ���ͨ,21��ѧͨjava,��վ����,����ϵͳ������ά��";
            String[] s1=s.split(",");
            System.out.println(s1.length);
            
            Goods goods=null;
            
            List<Goods> list=new ArrayList<>();
            for(int i=0;i<50;i++) {
	            goods=new Goods();
	            //goods.setGoods_id(i+8);
	            goods.setLtype_id(i%13+1);
	            goods.setGoodsName(s1[i%s1.length]);
	            goods.setIntroduce("��Ʒ"+i);
	            goods.setPrice(i+100);
	            goods.setNewPrice(i+50);
	            goods.setLnTime(new Date());
	            goods.setNewGoods(1);
	            goods.setSale(20);
	            goods.setGoods_total(50);
	            goods.setState(1);
	            goods.setType(1+i%5);
	            goods.setLogo_path("images/2.jpg");
	            list.add(goods);
            }
            
            dao.addMore(list);
           /* goods=new Goods();
            //goods.setGoods_id(5);
            goods.setLtype_id(1);
            goods.setGoodsName("111");
            goods.setIntroduce("��Ʒ");
            goods.setPrice(100);
            goods.setNewPrice(50);
            goods.setLnTime(new Date());
            goods.setNewGoods(1);
            goods.setSale(20);
            goods.setGoods_total(50);
            goods.setState(1);
            goods.setType(1);
            goods.setLogo_path("images/2.jpg");
	        dao.add(goods);*/
	}

}
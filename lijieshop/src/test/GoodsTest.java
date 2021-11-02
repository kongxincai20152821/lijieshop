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
            
            String s="电热火锅,洗衣机,饮水机,开心果,果味饮料,蛋糕,糖果,牛肉,连衣裙,休闲裤,妈妈装,java从入门到精通,21天学通java,网站开发,软件系统开发及维修";
            String[] s1=s.split(",");
            System.out.println(s1.length);
            
            Goods goods=null;
            
            List<Goods> list=new ArrayList<>();
            for(int i=0;i<50;i++) {
	            goods=new Goods();
	            //goods.setGoods_id(i+8);
	            goods.setLtype_id(i%13+1);
	            goods.setGoodsName(s1[i%s1.length]);
	            goods.setIntroduce("商品"+i);
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
            goods.setIntroduce("商品");
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

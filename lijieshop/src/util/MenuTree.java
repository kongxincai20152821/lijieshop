package util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;

import entity.Menu;

/**
 * 姝ょ被鐢ㄦ潵鐢熸垚easyui鏍煎紡鐨勬爲json瀛楃涓�
 * @author Administrator
 *
 */
public class MenuTree {

	private List<Menu> list;
	
	/**
	 * 鑾峰彇鎵�鏈夋牴鑺傜偣
	 * @return
	 */
	public List<Map<String, Object>> createSys_MenuTree(){
		List<Map<String, Object>> rootList = new ArrayList<>();
		for(Menu menu:list) {
			Map<String, Object> map = null;
			if(menu.getPcode()==null||menu.getPcode().equals("")) {//璇存槑鏄牴鑺傜偣
				map = new HashMap<String, Object>();
					map.put("id", menu.getCode());
					map.put("text", menu.getName());
					map.put("children", createSubSys_MenuTree(menu.getCode()));
					Map<String, Object> attrMap = new HashMap<String, Object>();
					attrMap.put("url", menu.getUrl());
					attrMap.put("state", menu.getState());
					map.put("attributes", attrMap);
			}
			if(map!=null&&map.get("id")!=null&&map.get("text")!=null) {
				rootList.add(map);
			}
		}
		return rootList;
	}
	/**
	 * 閫掑綊鑾峰彇鐖惰妭鐐逛笅鐨勬墍鏈夊瓙鑺傜偣
	 * @param pcode
	 * @return
	 */
	public List<Map<String, Object>> createSubSys_MenuTree(String pcode){
		List<Map<String, Object>> leafList = new ArrayList<>();
		for(Menu menu:list) {
			Map<String, Object> map = null;
			if(menu.getPcode()!=null&&menu.getPcode().equals(pcode)) {//瀛愯妭鐐�
				map = new HashMap<String, Object>();
				map.put("id", menu.getCode());
				map.put("text", menu.getName());
				map.put("children", createSubSys_MenuTree(menu.getCode()));
				Map<String, Object> attrMap = new HashMap<String, Object>();
				attrMap.put("url", menu.getUrl());
				attrMap.put("state", menu.getState());
				map.put("attributes", attrMap);
			}
			if(map!=null&&map.get("id")!=null&&map.get("text")!=null) {
				leafList.add(map);
			}
		}
		return leafList;
	}
	/**
	 * 杩斿洖鏍慾son鏍煎紡瀛楃涓�
	 * @return
	 */
	public String getSys_MenuTreeJson() {
		return JSONArray.toJSONString(createSys_MenuTree());
	}

	public List<Menu> getList() {
		return list;
	}

	public void setList(List<Menu> list) {
		this.list = list;
	}
}

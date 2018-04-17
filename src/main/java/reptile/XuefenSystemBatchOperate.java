package reptile;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class XuefenSystemBatchOperate {
	
	public ArrayList<String> getPraticeIDList() throws InterruptedException, IOException{
		org.jsoup.Connection connect = Jsoup.connect("http://14.23.100.146:7890/workflow/todoList.htm");
		
		
		File file = new File("C:\\Users\\kl\\Desktop\\log.txt");
		FileWriter writer = new FileWriter(file);
		
		Map<String, String> cookies = new HashMap<String, String>();
		cookies.put("JSESSIONID", "18271573FF1EE532C52F4B514BDC0C25");
		cookies.put("LTJ_WEBOA_LOGIN_ID", "990119");
		cookies.put("LastSelectNode", "webfx-tree-object-6");
		cookies.put("c_loginId", "");
		cookies.put("c_password", "");
		connect.cookies(cookies);
		
		
		org.jsoup.nodes.Document doc = null;
		try {
			doc = connect.get();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		Elements applyRecords = doc.getElementsByClass("odd");
		applyRecords.addAll(doc.getElementsByClass("even"));
		
		for(int i=0; i<applyRecords.size();i++){
			org.jsoup.nodes.Element record = applyRecords.get(i);
			Elements tds = record.getElementsByTag("td");
			if(!tds.isEmpty() && tds.get(2).text().substring(0, 10).compareToIgnoreCase("2017-07-01") < 0){
				org.jsoup.Connection connectApprove = Jsoup.connect("http://14.23.100.146:7890/workflow/bizWfApproveDialog.htm");
				connectApprove.cookies(cookies);
				
				String description = tds.get(0).text();
				String instanceId = "";
				String[] hrefStrs = tds.get(6).getElementsByTag("a").get(1).attr("href").toString().split("&");
				for(String str : hrefStrs){
					if(str.indexOf("instanceId=") != -1){
						instanceId = str.replaceFirst("instanceId=", "");
					}
				}
				
				Map<String, String> data = new HashMap<String, String>();
				data.put("todoId", "");
				data.put("form_name", "actionForm");
				data.put("bizdialog", "wf/DlgWfApproveAction");
				data.put("outcome", "已完成采购,申请入库");
				data.put("remarks", "NO COMMENT.");
				data.put("complete", "完成");
				data.put("invoiceNum", "000000000");
				
				data.put("description", description);
				data.put("instanceId", instanceId);
				
				connectApprove.data(data);
				try {
					Document applicationDoc = connectApprove.timeout(20000).post();
				} catch (IOException e) {
					e.printStackTrace();
				}
				System.out.println(description.concat("; ").concat(tds.get(1).text()).concat("; ").concat(instanceId));
				writer.append(description.concat("; ").concat(tds.get(1).text()).concat("; ").concat(instanceId).concat("\n"));
				}
		}
		
		writer.close();
		return null;
	}

	public static void main(String[] args) {
		XuefenSystemBatchOperate xisaiPraticeByDay = new XuefenSystemBatchOperate();
		try {
			xisaiPraticeByDay.getPraticeIDList();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

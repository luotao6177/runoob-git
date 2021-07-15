package com.note.Controller;

import com.note.Model.Gonggao;
import com.note.Service.GonggaoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import java.util.List;

/**
 * @author lt
 * @create 2020-05-12 23:56
 */
@Controller
public class GonggaoController {
    @Resource
    private GonggaoService gonggaoService;
    /**
     * 添加公告
     * @return
     */
    @RequestMapping("addGonggao.do")
    @ResponseBody
    public String addGonggao(Gonggao gonggao){
        String result = "";
        String gonggaoTitle = gonggao.getGonggaoTitle();
        try {
            System.out.println("开始启动insert");
            Gonggao gonggao1 = gonggaoService.selectGonggaoByTitle(gonggaoTitle);
            Integer id = gonggao1.getGonggaoId();
            if (id != null){
                //查询到数据 返回前台账号已存在
                result = "exists";
            }
        } catch (Exception e){
            //查询不到数据时 插入数据
            System.out.println("开始insert进数据库");
            gonggaoService.addGonggao(gonggao);
            Integer pid = gonggao.getGonggaoId();
            System.out.println(pid);
            result = "success";
        }
        System.out.println(result);
        return result;
    }

    /**
     * 获取公告列表
     * @return
     */
    @RequestMapping("getGonggaoList.do")
    @ResponseBody
    public List<Gonggao> getGonggaoList(){
        List<Gonggao> gonggaoList = null;
        try {
            gonggaoList = gonggaoService.getAllGonggao();
            Integer length = gonggaoList.size();
            if(length > 0) {
                return gonggaoList;
            }
        }catch (Exception e){

        }
        return gonggaoList;
    }

    /**
     * 删除公告
     * @param gonggao
     * @return
     */
    @RequestMapping("updategonggaoStatus.do")
    @ResponseBody
    public String updategonggaoStatus(Gonggao gonggao){
        String result = "";
        try {
            int id = gonggaoService.updategonggaoStatus(gonggao);
            if (id > 0){
                result = "success";
            }
        }catch (Exception e){
            result = "error";
        }

        return result;
    }

    /**
     * 根据公告Id获取公告信息
     * @param gonggao
     * @return
     */
    @RequestMapping("getGonggaoById.do")
    @ResponseBody
    public Gonggao getGonggaoById(Gonggao gonggao){
        Gonggao gonggao1 = null;
        Integer id = gonggao.getGonggaoId();
        try {
            Gonggao gonggao2 = gonggaoService.getGonggaoById(id);
            Integer gonggaoId = gonggao2.getGonggaoId();
            if (gonggaoId != null){
                gonggao1 = gonggao2;
            }
        }catch (Exception e){

        }
        return gonggao1;
    }
}

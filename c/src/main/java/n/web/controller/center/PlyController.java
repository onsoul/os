package n.web.controller.center;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import n.core.web.controller.GenericController;
import n.service.ply.IThirdPlyService;

@RequestMapping("oc/ply")
@Controller
public class PlyController extends GenericController {

	@Resource
	private IThirdPlyService thirdPlyService;

	@RequestMapping("/")
	public String plyIndex(Model model) {
		model.addAttribute("thirdPly", thirdPlyService.findToShow());
		return "center/ply/index";
	}

}
package com.phantom.stepbystep;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.phantom.model.PriceIncrease;
import com.phantom.model.Product;
import com.phantom.service.PriceIncreaseValidator;
import com.phantom.service.ProductManager;
import com.phantom.service.ProductValidator;

@Controller
public class HelloController {
	protected final Log logger = LogFactory.getLog(getClass());
	private static ProductManager productManager;
	@Autowired
	private PriceIncreaseValidator priceIncreaseValidator;
	@Autowired
	private ProductValidator productValidator;
	
	public void setProductManager(ProductManager productManager) {
		HelloController.productManager = productManager;
	}

	@RequestMapping("/home")
	public ModelAndView hello(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String now = (new Date()).toString();

		logger.info("Returning hello view: " + now);

		return new ModelAndView("home", "now", now);
	}

	@RequestMapping("/product")
	public ModelAndView manageProduct(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String now = (new Date()).toString();
		logger.info("returning product view with " + now);

		Map<String, Object> myModel = new HashMap<>();
		myModel.put("now", now);
		myModel.put("products", HelloController.productManager.getProducts());
		return new ModelAndView("product", "model", myModel);
	}

	@RequestMapping(value = "/priceincrease", method = RequestMethod.GET)
	public ModelAndView initIncreaseForm(ModelMap model) {
		String now = (new Date()).toString();
		logger.info("returning price increase view with " + now);
		Map<String, Object> myModel = new HashMap<>();
		myModel.put("now", now);

		PriceIncrease pi = new PriceIncrease();
		pi.setPercentage(20);
		model.addAttribute("priceIncrease", pi);

		return new ModelAndView("priceincrease", "model", myModel);
	}

	@RequestMapping(value = "/priceincrease", method = RequestMethod.POST)
	public ModelAndView increasePrice(@ModelAttribute("priceIncrease") PriceIncrease priceIncrease,
			BindingResult result) {
		int increase = priceIncrease.getPercentage();
		priceIncreaseValidator.validate(priceIncrease, result);
		if (!result.hasErrors()) {
			logger.info("Increase price " + increase + "%");
			HelloController.productManager.increasePrice(increase);
		}
		return new ModelAndView("increaseresult", "products",
				HelloController.productManager.getProducts());
	}

	@RequestMapping(value = "/createproduct", method = RequestMethod.GET)
	public ModelAndView initCreatForm(ModelMap model) {
		String now = (new Date()).toString();
		logger.info("returning create product view with " + now);
		Map<String, Object> myModel = new HashMap<>();
		myModel.put("now", now);

		Product product = new Product();
		product.setName("sample product");
		product.setPrice(00.00);
		System.out.println(product.toString());
		model.addAttribute("product", product);

		return new ModelAndView("createproduct", "model", myModel);

	}

	@RequestMapping(value = "/createproduct", method = RequestMethod.POST)
	public ModelAndView createProduct(@ModelAttribute("product") Product product,
			BindingResult result) {
		Product prod = product;
		System.out.println(prod.toString());
		productValidator.validate(prod, result);
		if (!result.hasErrors()) {
			logger.info("Create new product: " + prod.getName());
			HelloController.productManager.createProduct(prod);
			return new ModelAndView("createresult", "product", prod);
		} else {
			return new ModelAndView("createproduct");
		}
		
	}
}

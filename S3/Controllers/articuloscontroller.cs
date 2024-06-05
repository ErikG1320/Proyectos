using System.Diagnostics;
using Microsoft.AspNetCore.Mvc;
using S3.Models;

namespace S3.Controllers;

public class ArticulosController : Controller{
    public IActionResult Index()
    {
        return View();
    }
    public ActionResult Details (int id){
        return View();
    }
    public ActionResult Create(){
        return View();
    }
    public ActionResult Edit(int id){
        return View();
    }
    public ActionResult Delete(int id){
        return View();
    }
    public IActionResult Error()
    {
        return View(new ErrorViewModel { RequestId = Activity.Current?.Id?? HttpContext.TraceIdentifier });
    }
}
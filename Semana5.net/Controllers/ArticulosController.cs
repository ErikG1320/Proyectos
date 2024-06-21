using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;

using PrjBDVentas2023CRUD.Models;

namespace Semana5.net
{
    public class ArticulosController : Controller
    {
        // Inyección de Dependencia
        private readonly BDVENTAS2023okContext ctx;
        public ArticulosController(BDVENTAS2023okContext _ctx)
        {
            ctx = _ctx;
        }

        // GET: Articulos
        public ActionResult IndexArticulos(string nombre="")
        {
            var listado = ctx.Articulos.ToList();

            if (nombre != null)
                listado = listado.Where(
                             x => x.NomArt.StartsWith(nombre)).ToList();

            return View(listado);
        }

        // GET: Articulos/Details/5
        public ActionResult DetailsArticulos(string id)
        {
            // buscar un articulo por su codigo
            var buscado = ctx.Articulos.Find(id);

            return View(buscado);
        }

        // GET: Articulos/Create
        public ActionResult CreateArticulos()
        {
            /*
            // si vamos a enviar valores predeterminados a los campos
            // del modelo.
            Articulos nuevo = new Articulos();
            nuevo.PreArt = 1.0M;
            return View(nuevo);
            */

            // si no vamos a enviar valor predeterminados a los campos
            // del modelo.
            return View();
        }


        // POST: Articulos/Create
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult CreateArticulos(Articulos obj)
        {
            try {
                // si el modelo es válido
                if (ModelState.IsValid == true) {
                    // grabar en la tabla Articulos
                    ctx.Articulos.Add(obj); // grabar los datos en memoria
                    ctx.SaveChanges(); // grabar en la tabla de la BD
                    //
                    TempData["mensaje"] = 
                        $"El Articulo: {obj.NomArt} fué registrado correctamente";
                    //
                    return RedirectToAction(nameof(IndexArticulos));
                }
            }
            catch(Exception ex) {
                ViewBag.mensaje = ex.Message;
            }
            // enviar el modelo a la vista
            return View(obj);
        }

        // GET: Articulos/Edit/5
        public ActionResult Edit(int id)
        {
            return View();
        }

        // POST: Articulos/Edit/5
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit(int id, IFormCollection collection)
        {
            try
            {
                // TODO: Add update logic here

                return RedirectToAction(nameof(IndexArticulos));
            }
            catch
            {
                return View();
            }
        }

        // GET: Articulos/Delete/5
        public ActionResult Delete(int id)
        {
            return View();
        }

        // POST: Articulos/Delete/5
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Delete(int id, IFormCollection collection)
        {
            try
            {
                // TODO: Add delete logic here

                return RedirectToAction(nameof(IndexArticulos));
            }
            catch
            {
                return View();
            }
        }
    }
}
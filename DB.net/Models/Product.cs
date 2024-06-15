using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.EntityFrameworkCore;
using System.ComponentModel.DataAnnotations;

namespace DB.net.Models
{
    public class Product
    {
        public int Id { get; set; }
        [MaxLength(100)]
        public string Nombre { get; set; } = "";
        [MaxLength(100)]
        public string Marca { get; set; } = "";
        [MaxLength(100)]
        public string Categoria { get; set; } = "";
        [Precision(16, 2)]
        public decimal Precio { get; set; }
        [MaxLength(1000)]
        public string Descripcion { get; set; } = "";
        public int Stock { get; set; } = 0;
        [MaxLength(100)]
        public string Imagen { get; set; } = "";
        public DateTime Creacion { get; set; }
    }
}
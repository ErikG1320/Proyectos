using System;
using System.Collections.Generic;

namespace PrjBDVentas2023CRUD.Models
{
    public partial class Articulos
    {
        public Articulos()
        {
            VentasDeta = new HashSet<VentasDeta>();
        }

        public string CodArt { get; set; }
        public string NomArt { get; set; }
        public string UniMed { get; set; }
        public decimal? PreArt { get; set; }
        public int? StkArt { get; set; }
        public string EliArt { get; set; }

        public ICollection<VentasDeta> VentasDeta { get; set; }
    }
}

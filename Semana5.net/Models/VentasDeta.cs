using System;
using System.Collections.Generic;

namespace PrjBDVentas2023CRUD.Models
{
    public partial class VentasDeta
    {
        public string NumVta { get; set; }
        public string CodArt { get; set; }
        public int? Cantidad { get; set; }
        public decimal? Precio { get; set; }
        public string Anulado { get; set; }

        public Articulos CodArtNavigation { get; set; }
        public VentasCab NumVtaNavigation { get; set; }
    }
}

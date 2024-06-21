using System;
using System.Collections.Generic;

namespace PrjBDVentas2023CRUD.Models
{
    public partial class VentasCab
    {
        public VentasCab()
        {
            VentasDeta = new HashSet<VentasDeta>();
        }

        public string NumVta { get; set; }
        public DateTime? FecVta { get; set; }
        public string CodCli { get; set; }
        public int? CodVen { get; set; }
        public decimal? TotVta { get; set; }
        public string Anulado { get; set; }

        public Clientes CodCliNavigation { get; set; }
        public Vendedor CodVenNavigation { get; set; }
        public ICollection<VentasDeta> VentasDeta { get; set; }
    }
}

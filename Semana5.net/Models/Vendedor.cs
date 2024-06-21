using System;
using System.Collections.Generic;

namespace PrjBDVentas2023CRUD.Models
{
    public partial class Vendedor
    {
        public Vendedor()
        {
            VentasCab = new HashSet<VentasCab>();
        }

        public int CodVen { get; set; }
        public string NomVen { get; set; }
        public DateTime? FecingVen { get; set; }
        public int? CodDist { get; set; }
        public string EliVen { get; set; }

        public Distritos CodDistNavigation { get; set; }
        public ICollection<VentasCab> VentasCab { get; set; }
    }
}

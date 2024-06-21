using System;
using System.Collections.Generic;

namespace PrjBDVentas2023CRUD.Models
{
    public partial class Clientes
    {
        public Clientes()
        {
            VentasCab = new HashSet<VentasCab>();
        }

        public string CodCli { get; set; }
        public string NomCli { get; set; }
        public string CelCli { get; set; }
        public int? CredCli { get; set; }
        public int? CodDist { get; set; }
        public DateTime? FecNac { get; set; }
        public string EliCli { get; set; }

        public Distritos CodDistNavigation { get; set; }
        public ICollection<VentasCab> VentasCab { get; set; }
    }
}

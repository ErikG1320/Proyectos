using System;
using System.Collections.Generic;

namespace PrjBDVentas2023CRUD.Models
{
    public partial class Distritos
    {
        public Distritos()
        {
            Clientes = new HashSet<Clientes>();
            Vendedor = new HashSet<Vendedor>();
        }

        public int CodDist { get; set; }
        public string NomDist { get; set; }
        public string EliDist { get; set; }

        public ICollection<Clientes> Clientes { get; set; }
        public ICollection<Vendedor> Vendedor { get; set; }
    }
}

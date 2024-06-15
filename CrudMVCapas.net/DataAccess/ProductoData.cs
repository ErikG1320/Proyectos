namespace DataAccess
{
    public class ProductoData{string connectionString}
    {
        private readonly string _connectionString = connectionString;

        public List<Producto> GetAllProductos()
        {
            List<Producto> productos = [];
            using (SqlConnection connection = new(_connectionString))
            {
                string query ="SELECT Id,Nombre,Marca,Cantidad,Precio,Descripcion,Fecha FROM Productos";
                SqlCommand command = new(query, connection);
                connection.Open();
                SqlDataReader reader = command.ExecuteReader();
                while (reader.Read())
                {
                    Producto producto = new();
                    producto.Id = reader.GetInt32(0);
                    producto.Nombre = reader.GetString(1);
                    producto.Marca = reader.GetString(2);
                    producto.Cantidad = reader.GetInt32(3);
                    producto.Precio = reader.GetDecimal(4);
                    producto.Descripcion = reader.GetString(5);
                    producto.Fecha = reader.GetDateTime(6);
                    productos.Add(producto);
            }            
        }
    }
}
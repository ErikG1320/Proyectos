using System;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Metadata;

namespace PrjBDVentas2023CRUD.Models
{
    public partial class BDVENTAS2023okContext : DbContext
    {
        public BDVENTAS2023okContext()
        {
        }

        public BDVENTAS2023okContext(DbContextOptions<BDVENTAS2023okContext> options)
            : base(options)
        {
        }

        public virtual DbSet<Articulos> Articulos { get; set; }
        public virtual DbSet<Clientes> Clientes { get; set; }
        public virtual DbSet<Distritos> Distritos { get; set; }
        public virtual DbSet<Vendedor> Vendedor { get; set; }
        public virtual DbSet<VentasCab> VentasCab { get; set; }
        public virtual DbSet<VentasDeta> VentasDeta { get; set; }

        protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
        {
            if (!optionsBuilder.IsConfigured)
            {
#warning To protect potentially sensitive information in your connection string, you should move it out of source code. See http://go.microsoft.com/fwlink/?LinkId=723263 for guidance on storing connection strings.
                optionsBuilder.UseSqlServer("server=localhost;database=BDVENTAS2023ok;integrated security=true;");
            }
        }

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            modelBuilder.Entity<Articulos>(entity =>
            {
                entity.HasKey(e => e.CodArt);

                entity.Property(e => e.CodArt)
                    .HasColumnName("cod_art")
                    .HasMaxLength(5)
                    .IsUnicode(false)
                    .ValueGeneratedNever();

                entity.Property(e => e.EliArt)
                    .HasColumnName("eli_art")
                    .HasMaxLength(2)
                    .IsUnicode(false)
                    .HasDefaultValueSql("('No')");

                entity.Property(e => e.NomArt)
                    .HasColumnName("nom_art")
                    .HasMaxLength(50)
                    .IsUnicode(false);

                entity.Property(e => e.PreArt)
                    .HasColumnName("pre_art")
                    .HasColumnType("decimal(7, 2)");

                entity.Property(e => e.StkArt).HasColumnName("stk_art");

                entity.Property(e => e.UniMed)
                    .HasColumnName("uni_med")
                    .HasMaxLength(10)
                    .IsUnicode(false);
            });

            modelBuilder.Entity<Clientes>(entity =>
            {
                entity.HasKey(e => e.CodCli);

                entity.Property(e => e.CodCli)
                    .HasColumnName("cod_cli")
                    .HasMaxLength(5)
                    .IsUnicode(false)
                    .ValueGeneratedNever();

                entity.Property(e => e.CelCli)
                    .HasColumnName("cel_cli")
                    .HasMaxLength(10)
                    .IsUnicode(false);

                entity.Property(e => e.CodDist).HasColumnName("cod_dist");

                entity.Property(e => e.CredCli).HasColumnName("cred_cli");

                entity.Property(e => e.EliCli)
                    .HasColumnName("eli_cli")
                    .HasMaxLength(2)
                    .IsUnicode(false)
                    .HasDefaultValueSql("('No')");

                entity.Property(e => e.FecNac)
                    .HasColumnName("fec_nac")
                    .HasColumnType("date")
                    .HasDefaultValueSql("('10/10/1990')");

                entity.Property(e => e.NomCli)
                    .HasColumnName("nom_cli")
                    .HasMaxLength(50)
                    .IsUnicode(false);

                entity.HasOne(d => d.CodDistNavigation)
                    .WithMany(p => p.Clientes)
                    .HasForeignKey(d => d.CodDist)
                    .HasConstraintName("FK__Clientes__cod_di__29572725");
            });

            modelBuilder.Entity<Distritos>(entity =>
            {
                entity.HasKey(e => e.CodDist);

                entity.Property(e => e.CodDist)
                    .HasColumnName("cod_dist")
                    .ValueGeneratedNever();

                entity.Property(e => e.EliDist)
                    .HasColumnName("eli_dist")
                    .HasMaxLength(2)
                    .IsUnicode(false);

                entity.Property(e => e.NomDist)
                    .IsRequired()
                    .HasColumnName("nom_dist")
                    .HasMaxLength(40)
                    .IsUnicode(false);
            });

            modelBuilder.Entity<Vendedor>(entity =>
            {
                entity.HasKey(e => e.CodVen);

                entity.Property(e => e.CodVen).HasColumnName("cod_ven");

                entity.Property(e => e.CodDist).HasColumnName("cod_dist");

                entity.Property(e => e.EliVen)
                    .HasColumnName("eli_ven")
                    .HasMaxLength(2)
                    .IsUnicode(false)
                    .HasDefaultValueSql("('No')");

                entity.Property(e => e.FecingVen)
                    .HasColumnName("fecing_ven")
                    .HasColumnType("date");

                entity.Property(e => e.NomVen)
                    .HasColumnName("nom_ven")
                    .HasMaxLength(50)
                    .IsUnicode(false);

                entity.HasOne(d => d.CodDistNavigation)
                    .WithMany(p => p.Vendedor)
                    .HasForeignKey(d => d.CodDist)
                    .HasConstraintName("FK__Vendedor__cod_di__30F848ED");
            });

            modelBuilder.Entity<VentasCab>(entity =>
            {
                entity.HasKey(e => e.NumVta);

                entity.ToTable("Ventas_Cab");

                entity.Property(e => e.NumVta)
                    .HasColumnName("num_vta")
                    .HasMaxLength(8)
                    .IsUnicode(false)
                    .ValueGeneratedNever();

                entity.Property(e => e.Anulado)
                    .HasColumnName("anulado")
                    .HasMaxLength(2)
                    .IsUnicode(false)
                    .HasDefaultValueSql("('No')");

                entity.Property(e => e.CodCli)
                    .HasColumnName("cod_cli")
                    .HasMaxLength(5)
                    .IsUnicode(false);

                entity.Property(e => e.CodVen).HasColumnName("cod_ven");

                entity.Property(e => e.FecVta)
                    .HasColumnName("fec_vta")
                    .HasColumnType("date");

                entity.Property(e => e.TotVta)
                    .HasColumnName("tot_vta")
                    .HasColumnType("decimal(8, 2)")
                    .HasDefaultValueSql("((0))");

                entity.HasOne(d => d.CodCliNavigation)
                    .WithMany(p => p.VentasCab)
                    .HasForeignKey(d => d.CodCli)
                    .HasConstraintName("fk_Ventas_Cab_cod_cli");

                entity.HasOne(d => d.CodVenNavigation)
                    .WithMany(p => p.VentasCab)
                    .HasForeignKey(d => d.CodVen)
                    .HasConstraintName("fk_Ventas_Cab_cod_ven");
            });

            modelBuilder.Entity<VentasDeta>(entity =>
            {
                entity.HasKey(e => new { e.NumVta, e.CodArt });

                entity.ToTable("Ventas_Deta");

                entity.Property(e => e.NumVta)
                    .HasColumnName("num_vta")
                    .HasMaxLength(8)
                    .IsUnicode(false);

                entity.Property(e => e.CodArt)
                    .HasColumnName("cod_art")
                    .HasMaxLength(5)
                    .IsUnicode(false);

                entity.Property(e => e.Anulado)
                    .HasColumnName("anulado")
                    .HasMaxLength(2)
                    .IsUnicode(false)
                    .HasDefaultValueSql("('No')");

                entity.Property(e => e.Cantidad).HasColumnName("cantidad");

                entity.Property(e => e.Precio)
                    .HasColumnName("precio")
                    .HasColumnType("decimal(7, 2)");

                entity.HasOne(d => d.CodArtNavigation)
                    .WithMany(p => p.VentasDeta)
                    .HasForeignKey(d => d.CodArt)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("fk_Ventas_Deta_cod_art");

                entity.HasOne(d => d.NumVtaNavigation)
                    .WithMany(p => p.VentasDeta)
                    .HasForeignKey(d => d.NumVta)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("fk_Ventas_Deta_num_vta");
            });
        }
    }
}

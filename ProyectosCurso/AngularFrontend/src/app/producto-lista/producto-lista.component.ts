import { Component } from '@angular/core';
import { Producto } from '../producto';
import { ProductoService } from '../producto.service';

@Component({
  selector: 'app-producto-lista',
  templateUrl: './producto-lista.component.html'
})
export class ProductoListaComponent {
  productos: Producto[];

  constructor(private productoService: ProductoService) { }

  ngOnInit(){
    //Cargar todos los productos
    this.obtenerProductos();
  }

  private obtenerProductos(){
    //consumo los datos del observable(suscribirnos)
    this.productoService.obtenerProductosList().subscribe(producto => this.productos = producto);
  }

}

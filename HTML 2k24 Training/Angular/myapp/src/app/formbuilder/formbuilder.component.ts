import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators, ReactiveFormsModule, FormArray } from '@angular/forms';
import { CommonModule } from '@angular/common';
 
@Component({
  selector: 'app-formbuilder',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './formbuilder.component.html',
  styleUrls: ['./formbuilder.component.css']  // Corrected property
})
export class FormBuilderComponent {
  productForm: FormGroup;  // Define the form group
 
  // Constructor with dependency injection
  constructor(private formBuilder: FormBuilder) {
    // Initialize the form within the constructor
    this.productForm = this.formBuilder.group({
      productid: ['', [Validators.required, Validators.minLength(8)]],  // Default value as empty string
      brand: [''],
      description: this.formBuilder.group({
        age: [0],
        seasons: [''],
      }),
      qty: [0],
      price: [0],
      suppliers: this.formBuilder.array([
        this.formBuilder.control(''),
      ])
    });
  }
 
  onSubmit() {
    console.error(this.productForm);
    console.error(this.productForm.value);
    console.warn(this.productForm.controls['productid'].value);
    console.error(this.productForm.controls['description']?.get('age'));
    console.error(this.productForm.controls['description'].get('age')?.value);    
    // console.log(this.productForm.controls['description'].get['seasons']?.value)
    const suppliersArray = this.productForm.get('suppliers') as FormArray;
    console.log(suppliersArray.at(0)?.value);

    
    if (this.productForm.valid) {
      console.log('Form Submitted!', this.productForm.value);
    } else {
      console.log('Form is invalid');
    }
  }

  get suppliers(){
    return this.productForm.get('suppliers') as FormArray;
  }

  addNewSupplier(){
    console.warn(this.suppliers);
    this.suppliers.push(this.formBuilder.control(''));
  }
}
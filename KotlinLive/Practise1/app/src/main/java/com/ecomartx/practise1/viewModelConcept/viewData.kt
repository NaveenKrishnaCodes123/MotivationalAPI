package com.ecomartx.practise1.viewModelConcept

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


//view_model_proveder

      // It create Instance

//view_model_Store_owner

//view_model_store

  //val viewmodel= ViewModelProvider.create(this,NaveenViewModel.java)



//┌──────────────────────────┐
//│     Activity/Fragment     │  ← ViewModelStoreOwner
//│   (provides Store access) │
//└───────────────┬──────────┘
//│
//▼
//┌───────────────────┐
//│  ViewModelStore   │  ← Stores ViewModels
//└───────┬───────────┘
//│
//▼
//┌──────────────────────────────┐
//│      ViewModelProvider        │
//│  (checks store -> returns VM) │
//└──────────────┬───────────────┘
//│
//Returns Existing VM
//OR Creates New VM
//│
//▼
//┌────────────┐
//│ ViewModel   │  ← Survives Rotation
//└────────────┘

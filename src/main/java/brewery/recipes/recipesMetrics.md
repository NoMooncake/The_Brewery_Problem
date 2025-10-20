## **Package: brewery.recipes**

This package defines the static recipe domain model for the Brewery Problem.  
It specifies ingredients, their quantities, and recipe composition logic.

Classes in scope: `Ingredient`, `RecipeRequirement`, `Recipe`, `RecipeLibrary`.

| Class | WMC | DIT | NOC | CBO | RFC | **Design Comment** |
|:------|:---:|:---:|:---:|:---:|:---:|:--------------------|
| **Ingredient** | 2 | 1 | 0 | 1 | 2 | Immutable record representing a named brewing ingredient; minimal logic and zero mutable state. |
| **RecipeRequirement** | 5 | 1 | 0 | 2 | 4 | Holds an ingredient, amount, and unit; straightforward getters with strong cohesion. |
| **Recipe** | 15 | 1 | 0 | 5 | 10 | Defines composition of requirements and yield; moderate complexity from internal list management. |
| **RecipeLibrary** | 12 | 1 | 0 | 4 | 8 | Array-backed store of recipes; handles uniqueness checks, linear search, and snapshot generation. |
| **Total (Recipes)** | **34** | **4** | **0** | **12** | **24** | Aggregated totals for the recipe domain model. |
| **Average (Recipes)** | **8.5** | **1.0** | **0.0** | **3.0** | **6.0** | Shallow inheritance, moderate complexity from recipe composition, and low coupling; cohesive data relationships. |

### **Interpretation**
- **WMC:** Highest in `Recipe` and `RecipeLibrary` due to data management routines; all others remain trivial.
- **DIT / NOC:** Flat hierarchy (DIT = 1, NOC = 0), aligning with pure data-object modeling.
- **CBO:** Limited mainly to ingredient and requirement cross-links; no external dependencies.
- **RFC:** Each class exposes a compact, predictable interface.
- **Overall:** The recipe package demonstrates a clean, data-oriented design with minimal control logic, fitting the “library of definitions” role in the architecture.

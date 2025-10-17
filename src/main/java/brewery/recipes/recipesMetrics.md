## **Package: brewery.recipes**

This package defines recipe-domain data and lookup facilities used by production and inventory.  
It is intentionally data-centric: lightweight structures with small, stable APIs.

| Class | WMC | DIT | NOC | CBO | RFC | **Design Comment** |
|:------|:---:|:---:|:---:|:---:|:---:|:--|
| **Ingredient** | 1 | 1 | 0 | 0 | 1 | Immutable record holding a name; zero coupling and trivial interface. |
| **RecipeRequirement** | 3 | 1 | 0 | 1 | 3 | Single requirement (ingredient, amount, unit); tiny cohesive data holder used by `Recipe` and `Inventory`. |
| **Recipe** | 8 | 1 | 0 | 3 | 7 | Core recipe blueprint (name, targetTemp, gravity targets, requirements); moderate RFC due to collection access and helper queries. |
| **RecipeLibrary** | 5 | 1 | 0 | 2 | 5 | Central registry (add/get by name); light coupling to collections and exceptions; compact, stable API. |
| **Average (Recipes)** | **4.3** | **1** | **0** | **1.5** | **4** | Data-focused design with low complexity and minimal coupling; ideal for reuse across layers. |

> **Metric notes:**
> - **WMC:** Attributes + method statements (estimated by semicolons and simple operations).
> - **DIT:** All classes extend directly from `Object` (no inheritance tree).
> - **NOC:** No class serves as a parent; the package is intentionally flat.
> - **CBO:** Limited to use of Java collections and references to domain types (`Ingredient`, `RecipeRequirement`).
> - **RFC:** Small, stable public surfaces; `Recipe` has slightly higher RFC due to list/map management helpers.

### **Interpretation**
- **Low WMC & RFC:** Classes are simple, cohesive data abstractions—easy to reason about and test.
- **Minimal CBO:** Dependencies are limited to standard collections and local domain types, keeping modules decoupled.
- **Flat DIT/NOC:** A deliberately flat structure avoids inheritance complexity in the data layer.
- **Overall:** The recipes package provides a **clean, reusable model** that other layers (production, inventory) can depend on with minimal risk of ripple effects.

## **Package: brewery.inventory**

This package provides the array-backed inventory subsystem for the Brewery Problem.  
It includes two core classes: `Inventory` and `InventoryItem`.  
`Inventory` manages stock levels, threshold checks, and recipe-based reservations/rollbacks; `InventoryItem` encapsulates a single ingredient entry.

| Class | WMC | DIT | NOC | CBO | RFC | **Design Comment** |
|:------|:---:|:---:|:---:|:---:|:---:|:--------------------|
| **Inventory** | 22 | 1 | 0 | 6 | 14 | Array-backed store; linear scans; supports `hasFor / reserveFor / restoreFor` for all-or-nothing recipe reservations; thresholds via `reorderCheck`. |
| **InventoryItem** | 9 | 1 | 0 | 2 | 7 | Lightweight data holder with tiny mutators (`add/take`) and threshold helpers (`setThreshold/needsReorder`). |
| **Total (Inventory)** | **31** | **2** | **0** | **8** | **21** | Totals across all classes in the inventory layer. |
| **Average (Inventory)** | **15.5** | **1.0** | **0.0** | **4.0** | **10.5** | Low inheritance depth, small cohesive methods, and predictable coupling via a single façade-style API. |

### **Interpretation**
- **WMC:** `Inventory` carries more logic (capacity growth, lookups, reservation/rollback) but methods remain short and linear; `InventoryItem` stays minimal.
- **DIT/NOC:** Both classes inherit only from `Object` (DIT = 1) and define no subclasses (NOC = 0).
- **CBO:** `Inventory` couples to `Ingredient`, `Recipe`, `RecipeRequirement`, and its item type; coupling is focused and controlled.
- **RFC:** Public surface is compact (≈10–14 calls), aiding testability and clarity.
- **Overall:** The inventory package satisfies assignment constraints with an efficient array-based design and cohesive responsibilities per class.

## **Package: brewery.inventory**

This package manages the brewery’s ingredient storage and stock control.  
It contains two classes: `Inventory` (handles ingredient addition, checking, and consumption) and `InventoryItem` (represents a single ingredient entry).

| Class | WMC | DIT | NOC | CBO | RFC | **Design Comment** |
|:------|:---:|:---:|:---:|:---:|:---:|:--------------------|
| **Inventory** | 7 | 1 | 0 | 3 | 6 | Maintains ingredient quantities and supports basic operations like `add`, `has`, and `take`. Low complexity and high cohesion reflect clear single responsibility. |
| **InventoryItem** | 5 | 1 | 0 | 2 | 5 | Represents a single ingredient unit with quantity tracking; extremely cohesive, minimal external dependencies. |
| **Average (Inventory)** | **6** | **1** | **0** | **2.5** | **5.5** | The inventory layer shows lightweight design and strong cohesion with minimal coupling, ideal for reuse and testing. |

### **Interpretation**
- **WMC:** Both classes maintain low WMC, consistent with data-focused objects that handle simple operations.
- **DIT:** Inherits directly from `Object` (DIT = 1), keeping structure flat and easy to maintain.
- **CBO:** Low coupling indicates that inventory management is self-contained and not dependent on other subsystems.
- **RFC:** Each class exposes a small, stable API (about 5–6 methods), suitable for integration with higher-level logic like `BrewerySystem`.
- **Overall:** The `brewery.inventory` package demonstrates excellent **cohesion and modularity**, with very low complexity and high maintainability.

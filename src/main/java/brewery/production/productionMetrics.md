## **Package: brewery.production**

This package models the brewing process itself: batches, production states, readings, and transfer operations.  
It represents the dynamic workflow of creating, monitoring, and bottling beverages.

Classes in scope: `Batch`, `BatchStatus`, `BottlingLine`, `Reading`, `TransferOrder`.

| Class | WMC | DIT | NOC | CBO | RFC | **Design Comment** |
|:------|:---:|:---:|:---:|:---:|:---:|:--------------------|
| **Batch** | 14 | 1 | 0 | 5 | 10 | Core production entity linking recipe, vat, and readings; manages state transitions and logging; moderate complexity due to orchestration methods. |
| **BatchStatus (enum)** | 6 | 1 | 0 | 1 | 6 | Enum capturing production stages; minimal coupling, low complexity. |
| **BottlingLine** | 5 | 1 | 0 | 3 | 5 | Stub for future expansion; currently simulates bottling; small cohesive interface. |
| **Reading** | 4 | 1 | 0 | 2 | 4 | Data container for sensor metrics (e.g., temperature, gravity); pure value object. |
| **TransferOrder** | 6 | 1 | 0 | 3 | 5 | Represents scheduled liquid transfers; straightforward getters/setters; low coupling. |
| **Total (Production)** | **35** | **5** | **0** | **14** | **30** | Totals across the production subsystem. |
| **Average (Production)** | **7.0** | **1.0** | **0.0** | **2.8** | **6.0** | Balanced complexity: modest orchestration in `Batch`, simple cohesive data objects elsewhere; shallow inheritance. |

### **Interpretation**
- **WMC:** `Batch` has the highest due to multi-field coordination (state, vat, recipe, readings). Others remain lightweight.
- **DIT / NOC:** All classes inherit only from `Object`; no subclassing beyond the `enum` (DIT = 1, NOC = 0).
- **CBO:** Coupling limited to domain peers (`Vat`, `Recipe`, etc.); each class depends on a narrow set of external types.
- **RFC:** Compact public surface; no method explosion; cohesion remains high across classes.
- **Overall:** The production package provides a solid middle layer—slightly higher logic density in `Batch`, offset by lean, data-oriented support classes.

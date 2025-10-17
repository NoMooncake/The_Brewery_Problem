## **Package: brewery.production**

This package models the production process, representing batches, their lifecycle, monitoring readings, bottling, and transfer logistics.  
It connects the recipe and plant layers by managing real brewing data flow and state transitions.

| Class | WMC | DIT | NOC | CBO | RFC | **Design Comment** |
|:------|:---:|:---:|:---:|:---:|:---:|:--|
| **Batch** | 10 | 1 | 0 | 4 | 8 | Central entity representing a brewing batch; maintains readings and status; moderate complexity as it interfaces with recipes and vats. |
| **BatchStatus** | 1 | 1 | 0 | 0 | 1 | Enum capturing the lifecycle states; minimal logic, high readability. |
| **BottlingLine** | 3 | 1 | 0 | 1 | 3 | Contains stub methods for start/complete bottling; low coupling, easy to extend later. |
| **Reading** | 4 | 1 | 0 | 1 | 3 | Immutable data holder for monitoring readings; simple design with timestamp, temperature, gravity. |
| **TransferOrder** | 8 | 1 | 0 | 4 | 7 | Coordinates movement of batches between vats; interacts with `PathFinder`, `Manifold`, and `PlantRegistry`; expected higher coupling. |
| **Average (Production)** | **5.2** | **1** | **0** | **2** | **4.4** | Balanced design; slightly higher coupling due to orchestration responsibilities, but overall low complexity and strong cohesion. |

> **Metric notes:**
> - **WMC:** Combines attributes and method statements (estimated by semicolons).
> - **DIT:** All classes extend directly from `Object` (no subclassing).
> - **NOC:** None of the classes act as parents (no children).
> - **CBO:** `Batch` and `TransferOrder` show moderate coupling due to cross-layer coordination.
> - **RFC:** Derived from total methods + external calls; higher for orchestration classes.

### **Interpretation**
- **Moderate WMC:** `Batch` and `TransferOrder` have the highest WMC, reflecting their role as process coordinators.
- **Low DIT:** No inheritance hierarchy, simplifying maintenance and testing.
- **Low-to-moderate CBO:** Some necessary coupling for coordination (batches, vats, manifolds).
- **Small RFC:** Compact interfaces; methods are cohesive and task-specific.
- **Overall:** The production package is the **functional heart** of the system—cohesive, maintainable, and moderately complex by design.  
  It effectively bridges data (recipes) and physical processes (plant) without excessive coupling.

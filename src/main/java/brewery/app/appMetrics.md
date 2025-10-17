## **Package: brewery.app**

This package contains the core entry point and system controller for the Brewery Problem.  
It includes two main classes: `Main` and `BrewerySystem`.  
These classes manage initialization, dependency injection, and coordination between the various subsystems.

| Class | WMC | DIT | NOC | CBO | RFC | **Design Comment** |
|:------|:---:|:---:|:---:|:---:|:---:|:--------------------|
| **Main** | 3 | 1 | 0 | 7 | 8 | Minimal logic and low complexity; functions mainly as the bootstrap class responsible for launching the system. |
| **BrewerySystem** | 18 | 1 | 0 | 8 | 12 | Central façade of the application coordinating inventory, recipes, scheduling, and monitoring; expected higher coupling due to orchestration responsibilities. |
| **Average (App)** | **10.5** | **1** | **0** | **7.5** | **10** | The application layer shows moderate complexity, low inheritance depth, and predictable coupling; overall acts as a controller layer integrating all subsystems. |

### **Interpretation**
- **WMC:** The `BrewerySystem` has a higher WMC since it manages multiple subsystem interactions. `Main` remains minimal, reflecting good separation of startup logic and system coordination.
- **DIT:** Both classes inherit directly from `Object`, keeping the inheritance shallow (DIT = 1).
- **CBO:** Slightly higher coupling is intentional because `BrewerySystem` depends on six other modules, demonstrating proper dependency injection rather than tight binding.
- **RFC:** The moderate RFC (10–12) implies manageable interface complexity and clear method responsibilities.
- **Overall:** The `brewery.app` package effectively demonstrates low complexity and strong modular design at the system’s top level, consistent with controller design patterns.

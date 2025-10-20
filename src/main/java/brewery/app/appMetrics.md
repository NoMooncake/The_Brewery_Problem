## **Package: brewery.app**

This package contains the core entry point and system controller for the Brewery Problem.  
It includes three primary classes: `Main`, `BrewerySystem`, and `Console`.  
These classes manage initialization, dependency injection, coordination between subsystems, and centralized logging output.

| Class | WMC | DIT | NOC | CBO | RFC | **Design Comment** |
|:------|:---:|:---:|:---:|:---:|:---:|:--------------------|
| **Main** | 3 | 1 | 0 | 6 | 8 | Minimal logic and low complexity; serves purely as a bootstrap class for staged demo initialization. |
| **BrewerySystem** | 18 | 1 | 0 | 8 | 12 | Central façade coordinating inventory, recipes, plant registry, and services; higher coupling is intentional for orchestration. |
| **Console** | 4 | 1 | 0 | 2 | 4 | Lightweight static logger providing consistent formatted output; maintains low complexity and full cohesion. |
| **Total (App)** | **25** | **3** | **0** | **16** | **24** | Overall totals across all classes within the app layer. |
| **Average (App)** | **8.3** | **1.0** | **0.0** | **5.3** | **8.0** | The application layer shows moderate complexity, low inheritance depth, and intentional coupling through the façade; serves as a clean controller and presentation interface. |

### **Interpretation**
- **WMC:** The `BrewerySystem` carries higher WMC due to coordination logic across multiple systems. `Main` and `Console` remain lightweight, keeping the package average low.
- **DIT:** All classes inherit directly from `Object`; no deep inheritance trees (DIT = 1).
- **NOC:** No subclasses defined within this package, indicating a stable and final-level controller layer.
- **CBO:** Coupling is moderate, concentrated in the façade (`BrewerySystem`), while `Console` isolates I/O dependencies.
- **RFC:** Moderate RFC implies clear method boundaries and manageable public interfaces.
- **Overall:** The `brewery.app` package demonstrates a well-structured controller layer with low complexity, shallow inheritance, and high cohesion, effectively integrating all brewery subsystems under a single façade pattern.

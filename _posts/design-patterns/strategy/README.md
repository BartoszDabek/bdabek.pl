

---
layout: pattern
title: Strategy
categories: Behavioral
---

## Intent
Define a family of algorithms, encapsulate each one, and make them interchangeable. Strategy lets the algorithm vary independently from clients that use it.

## Explanation

Example

> Imagine that you're creating a game where you have different render options(DirectX, OpenGL). User decides what render he want to use, and additionally he can also change rendering options at runtime. We'll have different implementations of particular rendering options which in this case will be different strategies.


**Programmatic Example**

Let's take the above example. First of all we have to create interface 'RenderStrategy' and then implement concreate implementations  (DirectX and OpenGL)

```
public interface RenderStrategy {
    void render();
}

public class DirectX implements RenderStrategy {
    @Override
    public void render() {
        System.out.println("Using DirectX");
    }
}

public class OpenGL implements RenderStrategy {
    @Override
    public void render() {
        System.out.println("Using OpenGL");
    }
}
```

Next we creating context class, which is responsible for changing behavior (which implementation to use - DirectX or OpenGL). Context class also communicating with client directly.

```
public class Render {
    private RenderStrategy renderStrategy;

    public Render(RenderStrategy renderStrategy) {
        this.renderStrategy = renderStrategy;
    }

    public void render() {
        renderStrategy.render();
    }

    public void setRenderStrategy(RenderStrategy renderStrategy) {
        this.renderStrategy = renderStrategy;
    }
}
```

All done! Now we can use it

```
Render strategy = new Render(new DirectX());
strategy.render();		// output: "Using DirectX"

strategy.setRenderStrategy(new OpenGL());
strategy.render();		// output: "Using OpenGL"
```


## Structure

![strategy-structure](./etc/strategy-structure.png "strategy structure")
![example-structure](./etc/example-structure.png "example structure")

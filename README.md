# ClickCounter
This class listens for clicks, counts them and sends you the result trough a simple interface. Imagine trying to count how many times a view was clicked.

## Usage Example:

```Java
ClickCounter counter = new ClickCounter();


view.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        counter.addClick();
    }
});

counter.setClickCountListener(new ClickCounter.ClickCountListener() {
    @Override
    public void onClickingCompleted(int clickCount) {
        rewardUserWithClicks(clickCount); // Thats All!!😃
    }
});
```


## How to import this library:

Just copy and paste the ClickCounter.java class into your project classes. Enjoy

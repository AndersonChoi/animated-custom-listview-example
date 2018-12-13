# animated-custom-listview-example 🎊

[![platform](https://img.shields.io/badge/platform-Android-green.svg)](https://www.android.com)
[![API](https://img.shields.io/badge/API-19%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=19)
![](https://img.shields.io/badge/license-MIT-blue.svg)

Animted custom listview for android.

## Demo app

[<img src="https://raw.githubusercontent.com/AndersonChoi/animated-custom-listview-example/master/image/video.gif" width="250" />]()

## Usage

animated-custom-listview-example provides three effects.

* Alpha with translate animation
* Alpha animation
* Scale animation

```java
@Override
public View getView(int position, View convertView, ViewGroup parent) {
    Context context = parent.getContext();
    if (convertView == null) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.customlist_item, parent, false);
    }
    
    //1) Define animation
    Animation ...
    
    //2) Set animation on the item parent view
    convertView.setAnimation(animation);

    return convertView;
}
```

## Download
Just clone this repository.

```
git clone https://github.com/AndersonChoi/animated-custom-listview-example.git
```

## Contribute & Report issue

Did you encounter bugs? Pull request [here](https://github.com/AndersonChoi/animated-custom-listview-example/pulls) or Report them [here](https://github.com/AndersonChoi/animated-custom-listview-example/issues). The more relevant information you provide the easier and faster it can be resolved.

## License 

animated-custom-listview-example is released under the MIT license. See [LICENSE](https://github.com/AndersonChoi/animated-custom-listview-example/blob/master/LICENSE) for details.

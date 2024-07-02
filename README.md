# 概要
このアダプタは、LINEのチャネル(グループ)またはLINEユーザにイベント通知を送信します。

## はじめに

### 1- アダプタのインストール
まず、アダプタをビューサーバに追加します。
1. JENNIFER画面で、**設定** > **SMTP及びアダプタ(+DB Plan)** に移動します。
2. **[+ 追加]** ボタンをクリックし、**アダプタ** を選択します。
3. **区分** には **EVENT** を選択し、**ID** には **line** を入力します。
4. **パス** には、**[↑ファイルの選択]** をクリックして、ダウンロードしたLine用アダプタを選択します。
5. **クラス** には、**com.aries.line.LineAdapter** を入力します。
6. **[追加]**ボタンをクリックしてアダプタを追加します。

<img width="500" alt="img1" src="https://github.com/ju-hyun/jennifer-view-adapter-line/assets/30456085/7ddde066-0e41-49f0-af0f-10a67e0d29a6">


### 2- アダプタのオプション 
アダプタを追加しましたら、必要なオプションを追加します。必須オプションは **line_token** です。
残りのオプションはオプションで、必要に応じて設定します。このアダプタで使用可能なオプションの一覧は、以下の表を参照ください。

<img width="600" alt="img2" src="https://github.com/ju-hyun/jennifer-view-adapter-line/assets/30456085/8d40940c-9497-4ec0-9cae-fe171131330a">

<img width="500" alt="img4" src="https://github.com/ju-hyun/jennifer-view-adapter-line/assets/30456085/c3705006-2e4f-4172-8fdc-88110d70b35a">

以下の表に、このアダプタで使用可能なオプションを示します。

| キー                 | 必須    | 説明                    | デフォルト値   |
| ------------------- |:------:|-------------------------|:------------:|
| line_token          | ○      | LINEアクセストークンを設定 | なし         | 
| stickerPackageId    | ×      | ステッカーのパッケージID   | なし         | 
| stickerId           | ×      | ステッカーID             | なし         |
| notificationDisabled| ×      | true：メッセージ送信時に購読者に通知しない。ただし、LINEの通知をオフにしている場合は通知されません。 | false |
| eventLevel          | ×      | 通知するイベントのレベルを設定。設定したレベル以上のイベントが通知されます。ex) WARNINGを設定した場合、警告(WARNING)と致命的(FATAL)のイベントを通知　| NORMAL |

* LINEアクセストークン発行するには、LINEアカウントが必要です。
* LINEアクセストークンの発行は、[LINE Notify](https://notify-bot.line.me/ja/)で行えます。
* LINEアクセストークン発行時にグループを対象にした場合、通知を正常に受けるためには該当グループに **LINE Notify** をメンバーとして追加する必要があります。
* 使用可能なステッカーのパッケージIDとステッカーIDは[LINEステッカー一覧](https://developers.line.biz/ja/docs/messaging-api/sticker-list/)で確認できます。



以下は、このアダプタから受信したLINEメッセージの例です。

![lineexample](https://github.com/ju-hyun/jennifer-view-adapter-line/assets/30456085/be012bcf-b08b-4e3b-ab66-68388008ff52)
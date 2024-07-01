# Overview
This adapter will send EVENT notification to a line channel or a line user.

## Getting started

### 1- Installing the adapter
First, add the adapter to the view server. 1.
1. on the JENNIFER screen, navigate to **Setting** > **SMTP and Adapters (+DB Plan)** 2.
2. click the **[+ Add]** button and select **Adapter**. 
3. Select **EVENT** for **Classifications** and enter **line** for **ID**. 
4. For **Path**, click **[↑Choose File]** and select the adapter for Line that you downloaded. 
5. For **Class**, enter **com.aries.line.LineAdapter**. 
6. click the **[Add]** button to add the adapter.

<img width="500" alt="img1" src="https://github.com/ju-hyun/jennifer-view-adapter-line/assets/30456085/7ddde066-0e41-49f0-af0f-10a67e0d29a6">


### 2- Adapter Options

Next step is to add the adapter options. There are 1 required options that you must configure, the **line_token**. 
The rest of the options are optional. Refer the table below for the full list of available options for this adapter.

<img width="600" alt="img2" src="https://github.com/ju-hyun/jennifer-view-adapter-line/assets/30456085/8d40940c-9497-4ec0-9cae-fe171131330a">

<img width="500" alt="img4" src="https://github.com/ju-hyun/jennifer-view-adapter-line/assets/30456085/c3705006-2e4f-4172-8fdc-88110d70b35a">

The following table shows the available options for this adapter

| Key                 | Required      | Description   |  Default Value |
| ------------------- |:-------------:|:-------------:|:--------------:|
| line_token          | YES           | Set Line Access Token | None 
| stickerPackageId    | NO            | Package identifier    | None 
| stickerId           | NO            | Sticker identifier    | None
| notificationDisabled| NO            | true : Subscribers are not notified when sending messages. ¥n false : Subscriber is notified when the message is sent.However, if you turn off notifications on LINE, you will not be notified.          | false 


The following is an example of the line message received from this adapter.

![lineexample](https://github.com/ju-hyun/jennifer-view-adapter-line/assets/30456085/be012bcf-b08b-4e3b-ab66-68388008ff52)
